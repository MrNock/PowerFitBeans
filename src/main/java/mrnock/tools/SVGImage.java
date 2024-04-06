package mrnock.tools;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JLabel;

/**
 * Public class SVGImage used to add icons in the app.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class SVGImage extends JLabel {

    /**
     * <p>
     * FlatSVGIcon icon element.</p>
     */
    private FlatSVGIcon svgIcon;

    /**
     * <p>
     * This method sets the SVG Image (icon) to be used in the app.</p>
     *
     * @param image String with the image location path.
     * @param width SVG Image width value.
     * @param height SVG Image height value.
     */
    public void setSvgImage(String image, int width, int height) {
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }

}
