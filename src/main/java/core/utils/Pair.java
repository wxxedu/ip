package core.utils;

/**
 * A Pair of objects.
 *
 * @param <L> the type of the left object.
 * @param <R> the type of the right object.
 */
public class Pair<L, R> {
    /**
     * The left object.
     */
    private final L left;
    /**
     * The right object.
     */
    private final R right;

    /**
     * Creates a new pair of objects.
     *
     * @param left  the object stored as the left.
     * @param right the object stored as the right.
     */
    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Gets the left object.
     *
     * @return the object stored as left.
     */
    public L getLeft() {
        return left;
    }

    /**
     * Gets the right object.
     *
     * @return the object stored as right.
     */
    public R getRight() {
        return right;
    }
}
