package main;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class Filter extends FileFilter {
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		String extension = Utils.getExtension(f);
		if (extension != null) {
			if (extension.equals(Utils.bn)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "Filtre sur l'extension .bn";
	}
}
