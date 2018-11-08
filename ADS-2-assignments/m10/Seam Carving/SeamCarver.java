import java.awt.Color;
public class SeamCarver {
	// create a seam carver object based on the given picture
	private Picture pic;

	public SeamCarver(Picture picture) {
		if (picture == null) {
			throw new IllegalArgumentException("picture is null");
		} 
		this.pic = picture;
	}

	// current picture
	public Picture picture() {		
		return pic;
	}

	// width of current picture
	public int width() {
		return pic.width();
	}

	// height of current picture
	public int height() {
		return pic.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		/*int top = pic.getRGB(x, y - 1);
		int bottom = pic.getRGB(x, y + 1);
		int left = pic.getRGB(x - 1, y);
		int right = pic.getRGB(x + 1, y);
		int[] t = new int[] {(top >> 16) & 0xff, (top >> 8) & 0xff, (top & 0xff)};
		int[] b = new int[] {(bottom >> 16) & 0xff, (bottom >> 8) & 0xff, (bottom & 0xff)};
		int[] l = new int[] {(left >> 16) & 0xff, (left >> 8) & 0xff, (left & 0xff)};
		int[] r = new int[] {(right >> 16) & 0xff, (right >> 8) & 0xff, (right & 0xff)};
		int rv = Math.abs(t[0] - b[0]);
		int gv = Math.abs(t[1] - b[1]);
		int bv = Math.abs(t[2] - b[2]);
		int rh = Math.abs(l[0] - r[0]);
		int gh = Math.abs(l[1] - r[1]);
		int bh = Math.abs(l[2] - r[2]);
		return 0;*/
		if (x == 0 || y == 0 || pic.width() - 1 == x || pic.height() - 1 == y) {
			return 1000;
		}
		Color top = pic.get(x, y - 1);
		Color bottom = pic.get(x, y + 1);
		Color left = pic.get(x - 1, y);
		Color right = pic.get(x + 1, y);
		int red = right.getRed() - left.getRed();
		int blue = right.getBlue() - left.getBlue();
		int green = right.getGreen() - left.getGreen();
		int horizontal = red * red + blue * blue + green * green;
		int redv = top.getRed() - bottom.getRed();
		int bluev = top.getBlue() - bottom.getBlue();
		int greenv = top.getGreen() - bottom.getGreen();
		int vertical = redv * redv + bluev * bluev + greenv * greenv;
		double energy = Math.sqrt(horizontal + vertical);
		return energy;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}