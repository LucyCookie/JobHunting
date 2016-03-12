package SupplyHouse.com.ProductSupply;

import java.io.File;
import java.sql.PreparedStatement;

/**
 * Processor for csv file whose extension is "csv".
 * Created by qiqu on 2/1/16.
 */
public class CSVProcessor extends FileProcessor {
    CSVProcessor(String supplierID, PreparedStatement pst, File file) {
        super(supplierID, pst, file);
        this.delimiter = getDelimiter();
    }

    @Override
    public boolean transferToDB() {
        return false;
    }
}
