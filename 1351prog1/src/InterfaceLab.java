/* Alvarado, Elizabeth
 * CSC 1351, Section 2
 * Program 01
 */
import java.util.Random;

public class InterfaceLab implements IntSequence {
	int[] data;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (data.length > 0) {
			sb.append(data[0]);
			for (int i = 1; i < data.length; i++) {
				sb.append("," + data[i]);
			}
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int nextInt() {
		int retVal = data[0];
		int[] newData = new int[data.length - 1];
		for (int i = 1; i < data.length; i++) {
			newData[i - 1] = data[i];
		}
		data = newData;
		return retVal;
	}

	@Override
	public boolean hasNextInt() {
		return data.length > 0;
	}

	@Override
	public IntSequence generateRandom(int len, int minVal, int maxVal) {
		InterfaceLab iL = new InterfaceLab();
		iL.data = new int[len];
		Random rand = new Random();
		for (int i = 0; i < len; i++) {
			iL.data[i] = rand.nextInt(maxVal - minVal + 1) + minVal;
		}
		return iL;
	}

	@Override
	public IntSequence generate(int start, int end) {
		InterfaceLab iL = new InterfaceLab();
		if (start < end) {
			int numVals = end - start + 1;
			iL.data = new int[numVals];
			int n = 0;
			for (int i = start; i <= end; i++)
				iL.data[n++] = i;
		} else {
			int numVals = start - end + 1;
			iL.data = new int[numVals];
			int n = 0;
			for (int i = start; i >= end; i--)
				iL.data[n++] = i;
		}
		return iL;
	}

	@Override
	public IntSequence generate(int[] data) {
		InterfaceLab interfaceLab = new InterfaceLab();
		interfaceLab.data = new int[data.length];
		for (int i = 0; i < data.length; i++)
			interfaceLab.data[i] = data[i];
		return interfaceLab;
	}

	@Override
	public IntSequence generateReverse() {
		InterfaceLab iL = new InterfaceLab();
		iL.data = new int[data.length];
		int n = 0;
		for (int i = data.length - 1; i >= 0; i--) {
			iL.data[i] = data[n++];
		}
		return iL;
	}

}
