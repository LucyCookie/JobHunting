package SupplyHouse.com.ProductSupply;

/**
 * Created by qiqu on 2/1/16.
 * The common behaviour that file processors share.
 */
public interface DataProcessor {
    /**
     * Figure out the file's delimiter.
     *
     * @return the file's delimiter
     */
    public String getDelimiter();

    /**
     * Get the column index of the ProductID.
     *
     * @return the column index of the ProductID
     */
    public int getProductColumn();

    /**
     * Get the column index of the Quantity.
     *
     * @return the column index of the Quantity
     */
    public int getQuantityColumn();

    /**
     * Read the file line by line and transfer the record into the database with previously prepared statement.
     *
     * @return if transferred successfully
     */
    public boolean transferToDB();
}
