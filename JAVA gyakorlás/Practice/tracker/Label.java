package tracker;

public class Label {
	private String name;

	public String getName() {
		return name;
	}

	public Label (String text) {
		this.name = text;
	}

	public boolean isSame (Label l) {
		return this.name.equals(l.getName());
	}
}
