import java.awt.Color;
/**
 * Class for seam carver.
 */
public class SeamCarver {
    /**
     * border variable.
     */
    private static final double BORDER = 1000;
    /**
     * picture variable.
     */
    private Picture pic;
    /**
     * Constructs the object.
     *
     * @param      picture  The picture
     */
    public SeamCarver(final Picture picture) {
        if (picture == null) {
            throw new java.lang.IllegalArgumentException("picture is null");
        }
        this.pic = new Picture(picture);
    }
    /**
     * this is a picture method.
     *
     * @return picture.
     */
    public Picture picture() {
        return this.pic;
    }
    /**
     * width of current picture.
     *
     * @return width.
     */
    public int width() {
        return this.pic.width();
    }

    /**
     *  height of current picture.
     *
     * @return height of current picture.
     */
    public int height() {
        return this.pic.height();
    }

    /**
     * energy of pixel at column x and row y.
     *
     * @param      x  integer.
     * @param      y  integer.
     *
     * @return  // energy of pixel at column x and row y.
     */
    public  double energy(final int x, final int y) {
        int w = width() - 1, h = height() - 1;
        if (x < 0 || x > w || y < 0 || y > h) {
            throw new
            java.lang.IllegalArgumentException("IllegalArgumentException");
        }
        if (x == 0 || x == w ||  y == 0 || y == h) {
            return BORDER;
        }
        return internalEnergy(x, y);
    }

    /**
     * internal energy of pixel at column x and row y not on border.
     *
     * @param      x  integer
     * @param      y  integer
     *
     * @return  // energy of pixel at column x and row y not on border.
     */
    private double internalEnergy(final int x, final int y) {
        Color right = this.pic.get(x + 1, y);
        Color left = this.pic.get(x - 1, y);
        Color up = this.pic.get(x, y - 1);
        Color down = this.pic.get(x, y + 1);
        return Math.sqrt(gradient(left, right) + gradient(up, down));
    }
    /**
     * energy storage function.
     *
     * @return  energies
     */
    private double[][] initEnergies() {
        double[][] energies = new double[height()][width()];
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                energies[i][j] = energy(j, i);
            }
        }
        return energies;
    }
    /**
     * this is a gradient method.
     *
     * @param      one   One
     * @param      two   Two
     *
     * @return  gradient horizontal and vertical.
     */
    private double gradient(final Color one, final Color two) {
        double red = one.getRed() - two.getRed();
        double green = one.getGreen() - two.getGreen();
        double blue = one.getBlue() - two.getBlue();
        return red * red + green * green + blue * blue;
    }
    /**
     *  // pass through an array and mark the.
     *   shorthest distance from top to entry.
     *
     * @param      energies  The energies
     */

    private void topologicalSort(final double[][] energies) {
        int h = energies.length, w = energies[0].length;
        for (int row = 1; row < h; row++) {
            for (int col = 0; col < w; col++) {
                double temp = energies[row - 1][col];
                double min = 0;
                if (col == 0) {
                    min = temp;
                } else {
                    min = Math.min(temp, energies[row - 1][col - 1]);
                }

                if (col != (w - 1)) {
                    min = Math.min(min, energies[row - 1][col + 1]);
                } else {
                    min = min;
                }
                energies[row][col] += min;
            }
        }

    }
    /**
     * transpose matrix.
     *
     * @param      energies  The energies
     *
     * @return   transposed energies.
     */
    private double[][] transposeGrid(final double[][] energies) {
        int h = energies.length, w = energies[0].length;
        double[][] totalEnergies = new double[w][h];
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                totalEnergies[col][row] = energies[row][col];
            }
        }
        return totalEnergies;
    }
    /**
     * this is a vertical path.
     *
     * @param      energies  The energies
     *
     * @return vertical energies.
     */
    private int[] minVerticalPath(final double[][] energies) {
        int h = energies.length, w = energies[0].length;
        int[] path = new int[h];
        topologicalSort(energies);
        path[h - 1] = 0;
        for (int i = 0; i < w; i++) {
            if (energies[h - 1][i] < energies[h - 1][path[h - 1]]) {
                path[h - 1] = i;
            }
        }
        for (int row = h - 2; row >= 0; row--) {
            int col = path[row + 1];
            path[row] = col;
            if (col > 0 && energies[row][col - 1] < energies[row][path[row]]) {
                path[row] = col - 1;
            }
            if (col < (w - 2) && energies[row][col + 1]
                < energies[row][path[row]]) {
                path[row] = col + 1;
            }
        }
        return path;
    }
    /**
     * sequence of indices for horizontal seam.
     *
     * @return  // sequence of indices for horizontal seam.
     */
    public int[] findHorizontalSeam() {
        double[][] transposeEnergies = transposeGrid(initEnergies());
        return minVerticalPath(transposeEnergies);
    }
   /**
    *  sequence of indices for vertical seam.
    *
    * @return   // sequence of indices for vertical seam.
    */
    public int[] findVerticalSeam() {
        double[][] normalEnergies = initEnergies();
        return minVerticalPath(normalEnergies);
    }
    /**
     * Removes a horizontal seam.
     *
     * @param      a int array.
     */
    public void removeHorizontalSeam(final int[] a) {
        if (height() <= 1 || !isValid(a, width(), height() - 1)) {
            throw
            new java.lang.IllegalArgumentException("IllegalArgumentException");
        }
        Picture pict = new Picture(width(), height() - 1);
        for (int w = 0; w < width(); w++) {
            for (int h = 0; h < a[w]; h++) {
                pict.set(w, h, this.pic.get(w, h));
            }

            for (int h = a[w] + 1; h < height(); h++) {
                pict.set(w, h - 1, this.pic.get(w, h));
            }

        }
        this.pic = pict;
    }

    /**
     * Removes a vertical seam.
     *
     * @param      a  int array.
     */
    public void removeVerticalSeam(final int[] a) {
        if (width() <= 1 || !isValid(a, height(), width())) {
            throw
            new java.lang.IllegalArgumentException("IllegalArgumentException");
        }
        Picture pict = new Picture(width() - 1, height());
        for (int h = 0; h < height(); h++) {
            for (int w = 0; w < a[h]; w++) {
                pict.set(w, h, this.pic.get(w, h));
            }


            for (int w = a[h] + 1; w < width(); w++) {
                pict.set(w - 1, h, this.pic.get(w, h));
            }

        }
        this.pic = pict;
    }
    /**
     * Determines if valid.
     *
     * @param      a      { parameter_description }
     * @param      len    The length
     * @param      range  The range
     *
     * @return     True if valid, False otherwise.
     */
    private boolean isValid(final int[] a, final int len, final int range) {
        if (a.length != len || a[0] < 0 || a[0] > range) {
            return false;
        }
        if (a == null) {
            return false;
        }
        for (int i = 1; i < len; i++) {
            if (a[i] < Math.max(0, a[i - 1] - 1)
                ||
                a[i] > Math.min(range, a[i - 1] + 1)) {
                return false;
        }
        }
        return true;
    }
}











