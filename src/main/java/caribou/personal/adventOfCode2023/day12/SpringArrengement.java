package caribou.personal.adventOfCode2023.day12;

import java.util.ArrayList;
import java.util.List;

public class SpringArrengement {
	List<String> detail;
	List<Integer> contiguous;
	
	public List<String> getDetail() {
		return new ArrayList<>(detail);
	}
	
	public SpringArrengement setDetail(final List<String> detail) {
		this.detail = detail;
		return this;
	}
	
	public List<Integer> getContiguous() {
		return contiguous;
	}
	
	public SpringArrengement setContiguous(final List<Integer> contiguous) {
		this.contiguous = contiguous;
		return this;
	}
	
	@Override
	public String toString() {
		return "SpringArrengement{" +
				"detail=" + this.detail +
				", contiguous=" + this.contiguous +
				'}';
	}
}
