public class Arr implements MyArray {
	private int size;
	private String[] data;

	public Arr() {
		data = new String[0];
		size = 0;
	}

	public Arr(MyArray mya) {
		data = new String[mya.size()];
		size = mya.size();
		for (int i = 0; i < size; i++) {
			data[i] = mya.get(i);
		}

	}

	public Arr(MyArray mya, int start, int end) {
		if (start < 0 || start >= end) {
			data = new String[0];
			size = 0;
		} else {
			data = new String[end - start];
			size = end - start;
			for (int i = 0; i < size; i++) {
				data[i] = mya.get(start + i);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (size > 0) {
			sb.append(data[0]);
			for (int i = 1; i < size; i++) {
				sb.append(", " + data[i]);
			}
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void set(int pos, String str) {
		if (pos >= 0 && pos < size)
			data[pos] = str;
	}

	@Override
	public String get(int pos) {
		if (pos < 0 || pos >= size)
			return null;
		return data[pos];
	}

	@Override
	public int get(String str) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(str))
				return i;
		}
		return -1;
	}

	@Override
	public boolean contains(String str) {
		for (int i = 0; i < size; i++)
			if (data[i] == str)
				return true;
		return false;
	}

	@Override
	public void append(String str) {
		String[] arr = new String[size + 1];
		for (int i = 0; i < size; i++)
			arr[i] = data[i];
		arr[arr.length - 1] = str;
		size++;
		data = arr;
	}

	@Override
	public int insert(int pos, String str) {
		if (pos < 0 || pos > size) {
			return -1;
		}
		String[] arr = new String[size + 1];
		if (pos < size) {
			for (int i = 0; i <= pos; i++) {
				arr[i] = data[i];
				if (i == pos) {
					arr[i] = str;
					for (int j = pos + 1; j < arr.length; j++)
						arr[j] = data[j - 1];
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				arr[i] = data[i];
			}
			arr[size] = str;
		}
		data = arr;
		size++;
		return pos;
	}

	@Override
	public String remove(int pos) {
		if (pos < 0 || pos >= size) {
			return null;
		}
		String removedVal = data[pos];
		String[] arr = new String[size - 1];
		if (pos < arr.length - 1)
			for (int i = 0; i <= pos; i++) {
				arr[i] = data[i];
				if (i == pos) {
					for (int j = pos; j < arr.length; j++) {
						arr[j] = data[j + 1];
					}
				}
			}
		else {
			for (int i = 0; i < pos; i++) {
				arr[i] = data[i];
			}
		}
		data = arr;
		size--;
		return removedVal;
	}

	@Override
	public int remove(String str) {
		boolean bool = false;
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (data[i].equals(str)) {
				bool = true;
				index = i;
				if (bool) {
					String[] arr = new String[size - 1];
					if (index < size - 1) {
						for (i = 0; i < arr.length; i++) {
							arr[i] = data[i];
						}
						for (i = index; i < arr.length; i++) {
							arr[i] = data[i + 1];
						}
					}
					data = arr;
					size--;
					return index;
				}
			}
		}
		return -1;
	}
}
