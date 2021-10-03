'use strict';

const e = React.createElement;

class LikeButton extends React.Component {
  constructor(props) {
    super(props);
    this.state = { liked: false };
  }

  render() {
    if (this.state.liked) {
      return 'Você clicou aqui!!!';
    }

    return e(
        <ReactInput>
            
        </ReactInput>
      'button',
      { onClick: () => this.setState({ liked: true }) },
      'Clique'
    );
  }
}

const domContainer = document.querySelector('#like_button_container');
ReactDOM.render(e(LikeButton), domContainer);