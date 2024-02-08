package edu.project4;

import edu.project4.Drawer.DrawerFlame;
import edu.project4.UsefulClasses.Pixel;


public class Runner {

    private Runner() {
    }

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {
        //var start = System.nanoTime();
        CreateFlame flame = new CreateFlame(3, 30_000, 20_000, 2.2, false);
        flame.render();
        Pixel[][] image = flame.gammaCorrection(flame.getMatrixDisplay());
        //var end = System.nanoTime() - start;
        //System.out.println(end);
        DrawerFlame drawerFlame = new DrawerFlame(1920, 1080);
        drawerFlame.drawFlame(image);
        drawerFlame.saveToFile();
    }
}
