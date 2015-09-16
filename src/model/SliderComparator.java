package model;

import java.util.Comparator;

/**
 * The slider comparator.
 *
 * @author dburkha1
 * @version Fall 2015
 */
public class SliderComparator implements Comparator<Slider> {
	@Override
	public int compare(Slider aSlider, Slider bSlider) {
		if (aSlider.score() < bSlider.score()) {
			return -1;
		}
		if (aSlider.score() > bSlider.score()) {
			return 1;
		}
		return 0;
	}
}