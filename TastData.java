import java.io.FileWriter;
import java.io.IOException;

public class TastData {
    long countIteration = 0;
    long count = 10,
        maxX = 100000,
        maxY = 100000,
        width = 10000,
        high = 10000;
    public long getmaxCordX() {
        return this.maxX + this.width;
    }

    public long getmaxCordY() {
        return this.maxY + this.high;
    }

    public static long getRandomDiceNumber(long param)
    {
        return (long) (Math.random() * param);
    }
    public void generateRect() {
        try(
                FileWriter writer = new FileWriter("data/testRect.txt", false))
        {
            for (int i = 0; i < this.count; i++) {
                String str;
                long randomX = getRandomDiceNumber(this.maxX),
                    randomY = getRandomDiceNumber(this.maxY),
                    X =  randomX + getRandomDiceNumber(this.width),
                    Y =  randomY + getRandomDiceNumber(this.high);
                str = randomX + ";" + randomY + ";" + X + ";" + Y + "\n";
                writer.write(str);
            }
            writer.flush();
        }
        catch(
                IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void generatePoints() {
        try(
                FileWriter writer = new FileWriter("/data/testPoint.txt", false))
        {
            for (int i = 0; i < this.count; i++) {
                String str;
                long randomX = getRandomDiceNumber(this.maxX),
                    randomY = getRandomDiceNumber(this.maxY);
                str = randomX + ";" + randomY + "\n";
                writer.write(str);
            }
            writer.flush();
        }
        catch(
                IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
