package tracker;

import java.util.LinkedList;

public class Issue {
	private String description;
	private LinkedList<Label> labels;
	private int milestone;

	public String getDescription() {
		return description;
	}

	public LinkedList<Label> getLabels() {
		return labels;
	}

	public int getMilestone() {
		return milestone;
	}

	public Issue(String description, Label[] labels, int milestone) {
		this.description = description;
		this.milestone = milestone;
		this.labels = new LinkedList<Label>();
		for(Label l : labels) {
			this.labels.add(l);
		}
	}

	public static Issue createIssue(String text) {
		text = text.replace('@',',').replace(':',',');
		String[] splitText = text.split(",");
		
		if (text.match("[a-zA-Z0-9]+")) {
			return new Issue(splitText[0],Arrays.copyOfRange(splitText[1],1,splitText.length-1),splitText[splitText.length);
		} else {
			return null;
		}

	}
}

