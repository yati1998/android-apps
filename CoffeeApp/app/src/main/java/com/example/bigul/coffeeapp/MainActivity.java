package com.example.bigul.coffeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 2;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       // display(1);
       // displayPrice(quantity * 5);

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int amount = calcPrice(hasWhippedCream,hasChocolate);
        EditText nameField = (EditText) findViewById(R.id.customer_name);
        String customer_name = nameField.getText().toString();
        String priceMessage = createOrderSummary(amount,hasWhippedCream,customer_name,hasChocolate) ;//"$" + (quantity * 5) + " for " + quantity + " coffees." + "\nThank You!";
        orderSummaryTextView(priceMessage);
        /*Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:20.2899,85.8102"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*/

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for coffee by " + customer_name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calcPrice(boolean addWhippedCream, boolean addChoco){
        int coffeePrice = 5 ;
        if(addWhippedCream) coffeePrice += 1;
        if(addChoco) coffeePrice += 2;

        return quantity * coffeePrice ;

    }

    private String createOrderSummary(int price,boolean addWhippedCream, String name, boolean addChoco){
        String priceMessage = "Name : " + name + "\n";
        priceMessage += "Add whipped cream? " + addWhippedCream ;
        priceMessage += "\nAdd chocolate? " + addChoco ;
        priceMessage += ("\nQuantity : " + quantity + "\n");
        priceMessage +=  "Total : $" + price ;
        priceMessage += "\nThank You!" ;
        return priceMessage;
    }

    public void increment(View view){
        if(quantity < 100)
        { quantity ++ ;
          display(quantity);}
    }

    public void decrement(View view){
        if(quantity > 0)
        { quantity -- ;
          display(quantity); }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

   /* private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    } */

    private void orderSummaryTextView(String message){
        TextView priceTextView= (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
}
