package ca.wescook.microbes.utilities;

public class UsefulMath {
	// Returns input number with range caps on floor and ceiling
	public static int range(int min, int val, int max) {
		return Math.max(Math.min(val, max), min);
	}
	public static float range(float min, float val, float max) {
		return Math.max(Math.min(val, max), min);
	}
}
