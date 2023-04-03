export class Auftrag {
    personId: string;
    bestellNummer: string;
    lieferadresse: Lieferadresse;
}

export interface Lieferadresse {
    name: string;
    strasse: string;
    ort: string;
    plz: number;
}
