package data;

/**
 * Essential data classes
 */

final public class DocPath {

        // A path in the file system.

        private final String path;

        public DocPath (String path) {
            if (path == null) throw new IllegalArgumentException("Path cannot be null");
            checkPath(path);

            this.path = path;
        }

        private void checkPath (String path) {
            if (path.length() < 5) throw new IllegalArgumentException("Path must have at least 5 characters");
            if (!path.matches("[A-Z]:\\\\[a-zA-Z0-9]+\\\\[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")) throw new IllegalArgumentException("Path must have the format X:\\folder\\file.extension");
        }

        public String getPath () { return path; }

        @Override
        public boolean equals (Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DocPath docPath = (DocPath) o;
            return path.equals(docPath.path);
        }

        @Override
        public int hashCode () { return path.hashCode(); }

        @Override
        public String toString () {
            return "DocPath{" + "path='" + path + '\'' + '}';
        }
}
