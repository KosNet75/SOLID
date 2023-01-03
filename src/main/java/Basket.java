import java.util.Map;

public class Basket {


  protected Map<String, Integer> prices; //Мап для хранения названий и количества
  protected Purchase[] purchases; // купленные товары

  public Basket(Map<String, Integer> prices) {
    this.purchases = new Purchase[prices.size()];
    this.prices = prices;
  }

  public void addPurchase(String title, int count) {
    for (int i = 0; i < purchases.length; i++) {
      if (purchases[i] == null) {
        purchases[i] = new Purchase(title, count);
        return;
      }
      if (purchases[i].title.equals(title)) {
        purchases[i].count += count;
        return;
      }
    }
  }

  public long sum() {
    long sum = 0;
    System.out.println("КОРЗИНА:");
    for (int i = 0; i < purchases.length; i++) {
      Purchase purchase = purchases[i];
        if (purchase == null) {
            continue;
        }
      System.out.println(
          "\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count
              * prices.get(purchase.title)) + " руб.");
      sum += (long) purchase.count * prices.get(purchase.title);
    }
    return sum;
  }

}
