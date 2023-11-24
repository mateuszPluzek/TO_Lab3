public class Board {
    private int width;
    private int height;

    private int padding;

    public Board(int width, int height, int padding) {
        this.width = width;
        this.height = height;
        this.padding = padding;
    }

    public int getHeight() {
        return height;
    }

    public int getPadding() {
        return padding;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
