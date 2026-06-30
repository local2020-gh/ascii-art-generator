package org.local;

public class AsciiArtGeneratorFilterTypes {
    public enum FilterTypes {
        AVERAGE_RGB,
        LUMINANCE
    }

    public static float filterPixel(int pixel, FilterTypes filterType) {
        int a = (pixel >> 24) & 0xFF;
        int r = (pixel >> 16) & 0xFF;
        int g = (pixel >> 8)  & 0xFF;
        int b =  pixel        & 0xFF;

        switch(filterType) {
            case AVERAGE_RGB:
                return (float)(r+g+b) / 765f;

            case LUMINANCE:
                return (
                    (0.2126f * ((float)r / 255f)) +
                    (0.7152f * ((float)g / 255f)) +
                    (0.0722f * ((float)b / 255f))
                );
        
            default:
                return 0f;
        }
    }
}
