package sockets.messaging;

import java.util.Optional;
import java.util.stream.Stream;

public enum BoundaryType {
	DELIMITER, LENGTH;
	public static BoundaryType getByOrdinal(int ordinal) {
		Optional<BoundaryType> bType = Stream.of(BoundaryType.values()).filter(c -> c.ordinal() == ordinal)
				.findFirst();
		if (bType.isPresent())
			return bType.get();
		return null;
	}
}