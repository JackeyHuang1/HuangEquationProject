public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public LinearEquation(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double slope() {
        return roundedToHundredth((y2-y1) / (double) (x2-x1));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    public String equation() {
        String sign = "+ ";
        if (yIntercept() < 0) {
            sign = " ";
        }
        String equation = "y = ";
        if (slope() == 0) {
            equation += yIntercept();
        } else if (slope() == 1) {
            equation += "x + " + yIntercept();
        } else if ((y2 - y1) % (x2 - x1) != 0) {
            equation += (y2 - y1) + "/" + (x2 - x1) + "x "+ sign + yIntercept();
        } else {
        equation += (int) slope() + "x "+ sign + yIntercept();
        }
        return equation;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public String coordinateForX(double x) {
        return "The point on the line is (" + x + ", " + roundedToHundredth(x * slope() + yIntercept()) + ")";
    }

    public void lineInfo() {
        System.out.println("\n -------- Line Info --------");
        System.out.println("The two points are " + "(" + x1 + ", " + y1 + ") " + "and " + "(" + x2 + ", " + y2 + ") ");
        System.out.println("The equation of this line is: " + equation());
        System.out.println("The slope of this line is: " + slope());
        System.out.println("The y-intercept of this line is: " + yIntercept());
        System.out.println("The distance of this line is: " + distance() + "\n");
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}