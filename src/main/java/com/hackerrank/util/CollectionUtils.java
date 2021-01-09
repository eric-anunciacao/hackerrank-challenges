package com.hackerrank.util;

import java.util.List;

public interface CollectionUtils {

	static <T> boolean hasNextAfter(List<T> list, int actualPosition) {
		return isNotEmpty(list) && list.size() > actualPosition + 1;
	}

	static <T> boolean isNotEmpty(List<T> list) {
		return !isEmpty(list);
	}

	static <T> boolean isEmpty(List<T> list) {
		return list == null || list.isEmpty();
	}

	static boolean isEmpty(Object[] array) {
		return array == null || array.length <= 0;
	}

}
