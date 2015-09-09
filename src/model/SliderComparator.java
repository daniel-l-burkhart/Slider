package model;

import java.util.Comparator;

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
