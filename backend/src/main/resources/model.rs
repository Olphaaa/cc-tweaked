struct Uuid {
    value: String
}

struct User {
    id: ObjectId
    uuid: Uuid
}

enum SupplierType {
    SOLAR,
    NUCLEAR,
    WIND
}

enum SuplierState {
    ON,
    IDLE,
    OFF
}

struct Location {
  x: u64,
  y: u64,
  z: u64,
  world: String
}

enum IOPortState {
    ON,
    OFF
}

struct IOPort {
    state: IOPortSate,
    transfert_rate: u64
    max_transfer_rate: u64
}

struct Site {
    id: ObjectId
    name:  String,
    owner: &User,
    suppliers: Vec<&Supplier>,
    storage: Vec<&Storage>
}

struct Supplier {
    id: ObjectId,
  type: SupplierType,
  location: Location,
  output: IOPort,
  state: SupplierState
}

struct Storage {
    id: ObjectId,
    capacity: u64,
    input: IOPort,
    output: IOPort
    location: Location
}