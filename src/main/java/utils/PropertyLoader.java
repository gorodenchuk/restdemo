//package utils;
//
//import java.io.*;
//import java.util.Properties;
//
//
//public class PropertyLoader {
//    private static Properties props;
//    private static final String PROP_FILE = "target/classes/project.properties";
//
//    protected static Properties getProperties()
//    {
//        if(props == null)
//        {
//            props = new Properties();
//            try {
//                props.load(new FileInputStream(PROP_FILE));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return props;
//    }
//
//    public static String loadProperty(String name) {
//        return getProperties().getProperty(name);
//    }
//
//    public static void setProperty(String propertyName, String propertyValue){
//        getProperties().setProperty(propertyName, propertyValue);
//        File f = new File(PROP_FILE);
//        OutputStream out = null;
//        try {
//            out = new FileOutputStream( f );
//            getProperties().store(out, "Storing props");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
