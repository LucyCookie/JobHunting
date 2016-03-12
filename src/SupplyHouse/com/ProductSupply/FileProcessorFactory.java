package SupplyHouse.com.ProductSupply;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;

/**
 * Factory to produce the right processor for a certain file.
 * Created by qiqu on 2/1/16.
 */
public class FileProcessorFactory {

    /**
     * Get the required processor for current file.
     * @param fileName the name of the file
     * @param fileExtension the extension of the file
     * @param pst the prepared statement for transferring the records to the database
     * @param file the file
     * @return a processor
     */
    public static FileProcessor getProcessor(String fileName, String fileExtension, PreparedStatement pst, File file) {
        /*FileProcessorFactory supplyFileProcessor = null;
        try {
            supplyFileProcessor = (FileProcessorFactory) Class.forName("SupplyHouse.com.ProductSupply."
                    + fileExtension.toUpperCase() + "Processor")
                    .getConstructor(new Class[]{String.class, PreparedStatement.class, File.class})
                    .newInstance(fileName, pst, file);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        return null;
    }
}
