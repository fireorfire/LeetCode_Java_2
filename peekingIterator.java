// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Integer peek = null;
    private Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    if (iterator.hasNext()) {
	        peek = iterator.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer tem = peek;
	    if (iterator.hasNext()) {
	        peek = iterator.next();
	    } else {
	        peek = null;
	    }
	    return tem;
	}

	@Override
	public boolean hasNext() {
	    if (peek == null) {
	        return false;
	    }
	    return true;
	}
}