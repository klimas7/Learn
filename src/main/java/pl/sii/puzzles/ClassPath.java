/**
 * C:\Workspace\Learn\sunit\pl\sii\puzzles\ClassPath.java
 * Friday, April 29, 2016
 */
package pl.sii.puzzles;
public class ClassPath {
    public static void main(String[] args) {
        System.out.println(ClassPath.class.getName().replaceAll(".","/") + ".class");
    }
}
