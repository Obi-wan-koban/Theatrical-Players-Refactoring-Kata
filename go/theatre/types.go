package theatre

type base.Performance struct {
	PlayID   string
	Audience int
}

type base.Play struct {
	Name string
	Type string
}

type base.Invoice struct {
	Customer     string
	Performances []base.Performance
}
