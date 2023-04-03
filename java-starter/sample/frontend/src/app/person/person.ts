export class Person {
    id: number;
    vorname: string;
    name: string;
    addresses?: Address[];
}

export class Address {
    strasse: string;
    ort: string;
    plz: number;
}
