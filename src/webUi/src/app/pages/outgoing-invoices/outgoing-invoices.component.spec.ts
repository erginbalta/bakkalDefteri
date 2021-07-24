import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutgoingInvoicesComponent } from './outgoing-invoices.component';

describe('OutgoingInvoicesComponent', () => {
  let component: OutgoingInvoicesComponent;
  let fixture: ComponentFixture<OutgoingInvoicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutgoingInvoicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutgoingInvoicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
