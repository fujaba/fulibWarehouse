package stocktaker;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class StockApp  
{

   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public StockApp setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_description = "description";

   private String description;

   public String getDescription()
   {
      return description;
   }

   public StockApp setDescription(String value)
   {
      if (value == null ? this.description != null : ! value.equals(this.description))
      {
         String oldValue = this.description;
         this.description = value;
         firePropertyChange("description", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_content = "content";

   private Page content;

   public Page getContent()
   {
      return content;
   }

   public StockApp setContent(Page value)
   {
      if (value != this.content)
      {
         Page oldValue = this.content;
         this.content = value;
         firePropertyChange("content", oldValue, value);
      }
      return this;
   }

   public static final String PROPERTY_storage = "storage";

   private Storage storage;

   public Storage getStorage()
   {
      return storage;
   }

   public StockApp setStorage(Storage value)
   {
      if (value != this.storage)
      {
         Storage oldValue = this.storage;
         this.storage = value;
         firePropertyChange("storage", oldValue, value);
      }
      return this;
   }

   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getId());
      result.append(" ").append(this.getDescription());
      result.append(" ").append(this.getUser());


      return result.substring(1);
   }

   public static final String PROPERTY_user = "user";

   private String user;

   public String getUser()
   {
      return user;
   }

   public StockApp setUser(String value)
   {
      if (value == null ? this.user != null : ! value.equals(this.user))
      {
         String oldValue = this.user;
         this.user = value;
         firePropertyChange("user", oldValue, value);
      }
      return this;
   }

   public Board findBoard(String boardId) { 
      for (final Board board : this.getStorage().getBoards()) {
         if (board.getId().equals(boardId)) {
            return board;
         }
      }
      Board newBoard = new Board();
      newBoard.setId(boardId);
      this.getStorage().withBoards(newBoard);
      return newBoard;
   }

   public Product findProduct(String productName) { 
      for (final Product product : this.getStorage().getProducts()) {
         if (product.getName().equals(productName)) {
            return product;
         }
      }
      Product newProduct = new Product();
      newProduct.setName(productName);
      this.getStorage().withProducts(newProduct);
      return newProduct;
   }

   public void login() { 
      Page loginScreen = new Page();
      loginScreen.setId("login-screen");
      loginScreen.setDescription("Login | button Scan | button Log");
      this.setContent(loginScreen);
      Content loginIn = new Content();
      Content passwordIn = new Content();
      Content loginButtonIn = new Content();
      loginIn.setId("login-in");
      passwordIn.setId("password-in");
      loginButtonIn.setId("login-button-in");
      loginIn.setDescription("input user?");
      passwordIn.setDescription("input password?");
      loginButtonIn.setDescription("button login");
      loginScreen.withContent(loginIn, passwordIn, loginButtonIn);
      loginButtonIn.setAction("runLogin login-in password-in scan");
      // --- Run it on heroku. ---
      // so far manually: https://enigmatic-garden-26783.herokuapp.com/
   }

   public void runLogin(String loginName, String password) { 
      this.setDescription(loginName);
      this.setUser(loginName);
   }

   public void scan() { 
      Content locationIn = new Content();
      Content productCodeIn = new Content();
      Content itemsIn = new Content();
      Content scanButton = new Content();
      locationIn.setId("location-in");
      productCodeIn.setId("product-code-in");
      itemsIn.setId("items-in");
      scanButton.setId("scan-button");
      locationIn.setDescription("input location bar code");
      productCodeIn.setDescription("input product bar code?");
      itemsIn.setDescription("input number of items?");
      scanButton.setDescription("button Done");
      scanButton.setAction("runScan location-in product-code-in items-in log");
      Page scanScreen = new Page();
      scanScreen.setId("scan-screen");
      scanScreen.setDescription("button Login | Scan | button Log");
      scanScreen.withContent(locationIn, productCodeIn, itemsIn, scanButton);
      this.setContent(scanScreen);
   }

   public void runScan(String location, String productCode, int items) { 
      Board result1 = this.findBoard(location);
      Board myBoard = result1;
      Product result2 = this.findProduct(productCode);
      Product myProduct = result2;
      myProduct.setItems(items);
      myBoard.withProducts(myProduct);
   }

   public void log() { 
      Page logScreen = new Page();
      logScreen.setId("log-screen");
      logScreen.setDescription("button Login | button Scan | Log");
      for (final Product product : this.getStorage().getProducts()) {
         Content newContent = new Content();
         newContent.setId(product.getName());
         logScreen.withContent(newContent);
         Element nameElem = new Element();
         nameElem.setText(product.getName());
         newContent.withElements(nameElem);
         Element itemsElem = new Element();
         itemsElem.setText(String.valueOf(product.getItems()));
         newContent.withElements(itemsElem);
         if (product.getBoard() != null) {
            Element boardElem = new Element();
            boardElem.setText(product.getBoard().getId());
            newContent.withElements(boardElem);
         }
      }
      this.setContent(logScreen);
   }

   public void init() { 
      Storage theStore = new Storage();
      theStore.setName("Store24");
      this.setStorage(theStore);
      this.setId("stock-man");
      this.setDescription("Stock Manager");
      this.login();
   }

}
