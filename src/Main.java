public class Main {
    public static void main(String[] args) {
        int n = 10;
        char[][] arr = new char[n][n];
        fillArray(arr);
        findPath(arr, 8, 3);
        print(arr);
    }

    private static void findPath(char[][] arrayChar, int x0, int y0) {
        char[][] arrayCharPath = new char[arrayChar.length][arrayChar.length];
        int x = x0;
        int y = y0;
        while (x != 0 || y != 0) {
            char direction = whereFrom(arrayChar, x, y, arrayCharPath);
            if (direction == 'N') {
                System.out.println("Upss..");
                break;
            } else if (direction == 'U') {
                arrayCharPath[x][y] = 'x';
                y -= 1;
            } else if (direction == 'L') {
                arrayCharPath[x][y] = 'x';
                x -= 1;
            }
        }
        for (y = 0; y < arrayChar.length; y++) {
            for (x = 0; x < arrayChar[y].length; x++) {
                if (x == x0 && y == y0) {
                    arrayChar[x][y] = 'Ч';
                } else if (arrayCharPath[x][y] == 'x') {
                    arrayChar[x][y] = 'x';
                }
            }
        }
    }

    private static char whereFrom(char[][] arrayChar, int x, int y, char memory[][]) {
        int leftX, leftY, upX, upY;
        if (memory[x][y] != '\u0000') {
            return memory[x][y];
        }
        if (x > 0) {
            leftX = x - 1;
            leftY = y;
            if (leftX == 0 && leftY == 0) {
                memory[x][y] = 'L';
                return 'L';
            } else {
                if (arrayChar[leftX][leftY] != '*') {
                    if (whereFrom(arrayChar, leftX, leftY, memory) != 'N') {
                        memory[x][y] = 'L';
                        return 'L';
                    }
                }
            }
        }
        if (y > 0) {
            upX = x;
            upY = y - 1;
            if (upX == 0 && upY == 0) {
                memory[x][y] = 'U';
                return 'U';
            } else {
                if (arrayChar[upX][upY] != '*') {
                    if (whereFrom(arrayChar, upX, upY, memory) != 'N') {
                        memory[x][y] = 'U';
                        return 'U';
                    }
                }
            }
        }
        memory[x][y] = 'N';
        return 'N';
    }

    public static void fillArray(char arrayChar[][]) {
        for (int i = 0; i < arrayChar.length; i++) {
            for (int j = 0; j < arrayChar[i].length; j++) {
                arrayChar[i][j] = '-';
            }
        }
        arrayChar[0][0] = 'Щ';
        arrayChar[0][3] = '*';
        arrayChar[0][4] = '*';
        arrayChar[1][4] = '*';
        arrayChar[1][6] = '*';
        arrayChar[1][7] = '*';
        arrayChar[2][3] = '*';
        arrayChar[2][5] = '*';
        arrayChar[2][9] = '*';
        arrayChar[3][1] = '*';
        arrayChar[4][6] = '*';
        arrayChar[5][2] = '*';
        arrayChar[5][5] = '*';
        arrayChar[6][3] = '*';
        arrayChar[6][6] = '*';
        arrayChar[6][7] = '*';
        arrayChar[6][8] = '*';
        arrayChar[7][7] = '*';
        arrayChar[8][7] = '*';
        arrayChar[9][5] = '*';
        arrayChar[9][6] = '*';
    }

    public static void print(char arrayChar[][]) {
        for (int i = 0; i < arrayChar.length; i++) {
            for (int j = 0; j < arrayChar[i].length; j++) {
                System.out.print(" " + arrayChar[i][j]);
            }
            System.out.println();
        }
    }
}
