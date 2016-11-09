import { PotailJuridiqueWebappPage } from './app.po';

describe('potail-juridique-webapp App', function() {
  let page: PotailJuridiqueWebappPage;

  beforeEach(() => {
    page = new PotailJuridiqueWebappPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
