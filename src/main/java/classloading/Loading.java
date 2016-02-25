package classloading;


import java.net.URL;
import java.net.URLClassLoader;

public class Loading {

    public static void main(String[] args) {

        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        do {
            System.out.println(classLoader);
        } while((classLoader = (URLClassLoader) classLoader.getParent()) != null);

        System.out.println("Bootstrap class loader");


        classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        do {
            System.out.println(classLoader);
            for(URL url : classLoader.getURLs()) {

                System.out.printf("\t %s\n", url.getPath());
            }
        } while((classLoader = (URLClassLoader) classLoader.getParent()) != null);

        System.out.println("Bootstrap class loader");




    }

}
