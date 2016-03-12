package SupplyHouse.com.ProductSupply;

import java.io.File;
import java.sql.PreparedStatement;

/**
 * Processor for tsv file whose extension is "tsv".
 * Created by qiqu on 2/1/16.
 */
public class TSVProcessor extends FileProcessor {
    TSVProcessor(String supplierID, PreparedStatement pst, File file) {
        super(supplierID, pst, file);
        this.delimiter = getDelimiter();
    }

    @Override
    public boolean transferToDB() {
        return false;
    }
}
