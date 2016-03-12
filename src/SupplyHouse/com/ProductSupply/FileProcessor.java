package SupplyHouse.com.ProductSupply;

import java.io.File;
import java.sql.PreparedStatement;

/**
 * File processor.
 * Created by qiqu on 2/1/16.
 */
public abstract class FileProcessor implements DataProcessor {
    PreparedStatement pst;//statement prepared in advance for transferring record to database
    String supplierID;//the supplierID
    String delimiter;//the file's delimiter
    File file;//the file that is to be processed
    int productColumn;//the column index of the ProductID
    int quantityColumn;//the column index of the Quantity

    FileProcessor(String supplierID, PreparedStatement pst, File file) {
        this.supplierID = supplierID;
        this.pst = pst;
        this.file = file;
    }

    @Override
    public String getDelimiter() {
        return null;
    }

    @Override
    public int getProductColumn() {
        return 0;
    }

    @Override
    public int getQuantityColumn() {
        return 0;
    }
}
