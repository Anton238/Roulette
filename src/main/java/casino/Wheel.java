package casino;

import field.Cell;
import field.Table;

public class Wheel {

    public Cell spinWheel() {
        int row = (int) (Math.random() * 12);
        int column = (int) (Math.random() * 2);
        return Table.getCell(row, column);
    }

}
