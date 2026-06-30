package org.local;

public class RowPixelsToCharactersThread extends Thread {
    public final int THREAD_ID;

    public final int[][] rows;
    public final int filledRows;

    public final char[] pallette;

    AsciiArtGeneratorFilterTypes.FilterTypes filterType;

    RowPixelsToCharactersThread(
        int threadID, int[][] rows,
        int filledRows,
        char[] pallette,
        AsciiArtGeneratorFilterTypes.FilterTypes filterType
    ) {
        this.THREAD_ID = threadID;

        this.rows = rows;
        this.filledRows = filledRows;

        this.pallette = pallette;

        this.filterType = filterType;

        this.output = new char[filledRows * (rows[0].length+1)];
    }

    public boolean finished = false;
    public boolean ignore = false;
    
    public char[] output;

    public volatile int rowIndex = 0;

    @Override
    public void run() {
        int outputIndex = 0;

        for(; rowIndex < this.filledRows; rowIndex++) {
            for(int pixelIndex = 0; pixelIndex < this.rows[this.rowIndex].length; pixelIndex++) {
                int pixel = this.rows[this.rowIndex][pixelIndex];
                pixel = (((pixel >> 16) & 0xFF) + ((pixel >> 8)  & 0xFF) + (pixel & 0xFF)) / 3;

                this.output[outputIndex++] = this.pallette[(int)(((float)pixel/255f) * (float)(this.pallette.length-1))];
            }
            this.output[outputIndex++] = '\n';
        }

        this.finished = true;
    }
}
