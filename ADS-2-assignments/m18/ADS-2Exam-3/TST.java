/******************************************************************************
 *  Compilation:  javac TST.java
 *  Execution:    java TST < words.txt
 *  Dependencies: StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/52trie/shellsST.txt
 *
 *  Symbol table with string keys, implemented using a ternary search
 *  trie (TST).
 *
 *
 *  % java TST < shellsST.txt
 *  keys(""):
 *  by 4
 *  sea 6
 *  sells 1
 *  she 0
 *  shells 3
 *  shore 7
 *  the 5
 *
 *  longestPrefixOf("shellsort"):
 *  shells
 *
 *  keysWithPrefix("shor"):
 *  shore
 *
 *  keysThatMatch(".he.l."):
 *  shells
 *
 *  % java TST
 *  theory the now is the time for all good men
 *
 *  Remarks
 *  --------
 *    - can't use a key that is the empty string ""
 *
 ******************************************************************************/

/**
 *  The {@code TST} class represents an symbol table of key-value
 *  pairs, with string keys and generic values.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>delete</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides character-based methods for finding the string
 *  in the symbol table that is the <em>longest prefix</em> of a given prefix,
 *  finding all strings in the symbol table
 *   that <em>start with</em> a given prefix,
 *  and finding all strings in the symbol
 *  table that <em>match</em> a given pattern.
 *  A symbol table implements the <em>associative
 *  array</em> abstraction:
 *  when associating a value with a key that is
 *  already in the symbol table,
 *  the convention is to replace the old value
 *  with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be {@code null}—setting the
 *  value associated with a key to {@code null}
 *  is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses a ternary search trie.
 *  <p>
 **/

/**
 * Class for tst.
 *
 * @param      <Value>  The value
 */
public class TST<Value> {
    /**
     * { var_description }.
     */
    private int n;              // size
    /**
     * { var_description }.
     */
    private Node<Value> root;   // root of TST
    /**
     * Class for node.
     *
     * @param      <Value>  The value
     */
    private static class Node<Value> {
        /**
         * { var_description }.
         */
        private char c;
        /**
         * { item_description }.
         */
        private Node<Value> left, mid, right;
        /**
         * { var_description }.
         */
        private Value val;
    }

    /**
     * Initializes an empty string symbol table.
     */
    public TST() {
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final String key) {
        if (key == null) {
            throw new
            IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the
     * given key if the key is in the symbol table
     *     and {@code null} if the key is not
     *     in the symbol table
     * @throws IllegalArgumentException if
     * {@code key} is {@code null}
     */
    public Value get(final String key) {
        if (key == null) {
            throw
            new IllegalArgumentException("calls get() with null argument");
        }
        if (key.length() == 0) {
            throw new
            IllegalArgumentException("key must have length >= 1");
        }
        Node<Value> x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      d     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node<Value> get(final Node<Value> x,
        final String key, final int d) {
        if (x == null) {
            return null;
        }
        if (key.length() == 0) {
            throw new
            IllegalArgumentException("key must have length >= 1");
        }
        char c = key.charAt(d);
        if      (c < x.c) {
            return get(x.left,  key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid,   key, d + 1);
        } else {
            return x;
        }
    }

    /**
     * Inserts the key-value pair into the symbol table,
     * overwriting the old value
     * with the new value if the key is already in the
     * symbol table.
     * If the value is {@code null}, this effectively deletes
     * the key from the symbol table.
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final String key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (!contains(key)) {
            n++;
        }
        root = put(root, key, val, 0);
    }
    /**
     * { function_description }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     * @param      d     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node<Value> put(final Node<Value> x,
        final String key, final Value val, final int d) {
        Node x1 = x;
        char c = key.charAt(d);
        if (x1 == null) {
            x1 = new Node<Value>();
            x1.c = c;
        }
        if (c < x1.c) {
            x1.left  = put(x1.left,  key, val, d);
        } else if (c > x1.c) {
            x1.right = put(x1.right, key, val, d);
        } else if (d < key.length() - 1) {
            x1.mid   = put(x1.mid,   key, val, d + 1);
        } else {
         x1.val   = val;
        }
        return x1;
    }
    /**
     * Returns all of the keys in the set that start with {@code prefix}.
     * @param prefix the prefix
     * @return all of the keys in the set that start with {@code prefix},
     *     as an iterable
     * @throws IllegalArgumentException if {@code prefix} is {@code null}
     */
    public Iterable<String> keysWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        Queue<String> queue = new Queue<String>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.enqueue(prefix);
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }

    // all keys in subtrie rooted at x with given prefix
    private void collect(Node<Value> x, StringBuilder prefix, Queue<String> queue) {
        if (x == null) return;
        collect(x.left,  prefix, queue);
        if (x.val != null) queue.enqueue(prefix.toString() + x.c);
        collect(x.mid,   prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }


    /**
     * Returns all of the keys in the symbol table that match {@code pattern},
     * where . symbol is treated as a wildcard character.
     * @param pattern the pattern
     * @return all of the keys in the symbol table that match {@code pattern},
     *     as an iterable, where . is treated as a wildcard character.
     */
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new Queue<String>();
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }

    private void collect(Node<Value> x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
        if (x == null) return;
        char c = pattern.charAt(i);
        if (c == '.' || c < x.c) collect(x.left, prefix, i, pattern, queue);
        if (c == '.' || c == x.c) {
            if (i == pattern.length() - 1 && x.val != null) queue.enqueue(prefix.toString() + x.c);
            if (i < pattern.length() - 1) {
                collect(x.mid, prefix.append(x.c), i + 1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.c) collect(x.right, prefix, i, pattern, queue);
    }

    /*public boolean hasPrefix(String prefix) {
        Node<Value> prefixNode = get(root, prefix, 0);
        if (prefixNode == null) return false;
        if (prefixNode.val != null) return true;
        if (prefixNode.left == null && prefixNode.mid == null &&
                prefixNode.right == null) return false;
        return true;
    }*/
}
