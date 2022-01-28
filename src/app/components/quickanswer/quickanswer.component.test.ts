import * as quickanswer_component from './quickanswer.component';
// @ponicode
describe('quickanswer_component.QuickanswerComponent.ngOnInit', () => {
  let inst: any;

  beforeEach(() => {
    inst = new quickanswer_component.QuickanswerComponent();
  });

  test('0', () => {
    let result: any = inst.ngOnInit();
    expect(result).toMatchSnapshot();
  });
});
