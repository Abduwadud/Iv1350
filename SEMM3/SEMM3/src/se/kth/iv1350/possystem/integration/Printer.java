package se.kth.iv1350.possystem.integration;

import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.Receipt;

/**
 * Simulates an external printer that prints out a receipt after a sale.
 */
public class Printer {

    /**
     * Creates a new printer instance.
     */
    public Printer() {
        // Nothing needed here right now.
    }

    /**
     * Prints a receipt with the sale details.
     * Uses the totals stored in the Receipt instead of recomputing incorrectly.
     */
    public void print(Receipt receipt) {
        System.out.println("-------- Receipt --------");
        System.out.println("Printing receipt...");
        System.out.println("Date and time of purchase: " + receipt.getTimeOfSale());
        System.out.println("Store: " + receipt.getStoreName());
        System.out.println("Total discount: " + String.format("%.2f", receipt.getTotalDiscount()));

        System.out.println("Items:");
        for (Item item : receipt.getSoldItems()) {
            String itemName = item.getItemDTO().getItemName();
            double price = item.getItemDTO().getPrice();
            double vat = item.getItemDTO().getVAT();
            // If you need quantities or line totals, consider extending Receipt to include quantities.
            System.out.println(String.format("- %s %.2f SEK (VAT: %.2f SEK)", itemName, price, vat));
        }

        // Print the correct aggregated totals from the Receipt
        System.out.println("Total price: " + String.format("%.2f", receipt.getTotalPrice()) + " SEK");
        System.out.println("Total VAT: " + String.format("%.2f", receipt.getTotalVAT()) + " SEK");
        System.out.println("--------------------------");
    }
}
