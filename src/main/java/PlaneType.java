public enum PlaneType {

        DOUGLASMD(176),
        DREAMLINER(244),
        BOEING(366),
        AIRBUS(566);

        private final int capacity;

        PlaneType(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return this.capacity;
        }

}

