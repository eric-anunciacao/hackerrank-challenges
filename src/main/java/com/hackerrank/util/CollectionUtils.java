package com.hackerrank.util;

import java.util.List;

public interface CollectionUtils {

	static <T> boolean isEmpty(List<T> list) {
		return list == null || list.isEmpty();
	}

}
