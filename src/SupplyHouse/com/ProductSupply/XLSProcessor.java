package SupplyHouse.com.ProductSupply;

import java.io.File;
import java.sql.PreparedStatement;

/**
 * Processor for excel file whose extension is "xls".
 * Created by qiqu on 2/1/16.
 */
public class XLSProcessor extends FileProcessor {
    XLSProcessor(String supplierID, PreparedStatement pst, File file) {
        super(supplierID, pst, file);
        this.delimiter = getDelimiter();
    }

    @Override
    public boolean transferToDB() {
        return false;
    }
}
