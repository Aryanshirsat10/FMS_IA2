import React, { useState } from 'react';

const styles = {
  appContainer: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    minHeight: '100vh',
    maxHeight: '100vh',
    overflow: 'hidden',
  },
  appTitle: {
    backgroundColor:'black',
    color: 'white',
    position: 'absolute',
    top: '0px',
    left: '10px',
    display: 'flex',
    alignItems: 'center',
    fontSize: '2em'
  },
  bookIcon: {
    marginRight: '10px',
    height: '60px',
  },
  loginContainer: {
    fontFamily: 'Inter, system-ui, Avenir, Helvetica, Arial, sans-serif',
    lineHeight: '1.5',
    fontWeight: '200',
    color: 'black',
    fontSynthesis: 'none',
    textRendering: 'optimizeLegibility',
    WebkitFontSmoothing: 'antialiased',
    MozOsxFontSmoothing: 'grayscale',
    margin: '0',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    minWidth: '320px',
    minHeight: '100vh',
  },
  loginBox: {
    width: '100%',
    maxWidth: '400px',
    paddingTop: '20px',
    backgroundColor: 'white',
    borderRadius: '8px',
  },
  loginTitle: {
    fontSize: '3.0em',
    lineHeight: '1.1',
    marginBottom: '20px',
    marginTop: '0px',
    textAlign: 'center',
    fontWeight:'bold'
  },
  loginForm: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center', // Center-aligns the input boxes
    justifyContent: 'center', // Vertically centers the input boxes
  },
  formGroup: {
    marginBottom: '15px',
  },
  formLabel: {
    fontSize: '1.1em',
    marginBottom: '5px',
    display: 'block',
    textAlign: 'center',
  },
  formInput: {
    padding: '10px',
    borderRadius: '4px',
    border: '1px solid #ccc',
    fontSize: '1em',
  },
  loginButton: {
    borderRadius: '8px',
    border: '1px solid transparent',
    padding: '0.6em 1.2em',
    fontSize: '1em',
    fontWeight: '500',
    fontFamily: 'inherit',
    backgroundColor: '#1a1a1a',
    cursor: 'pointer',
    transition: 'border-color 0.25s',
    color: 'white',
    width:'100%'
  },
};

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Email:', email);
    console.log('Password:', password);
  };

  return (
    <div style={styles.loginContainer}>
      <div style={styles.loginBox}>
        <h1 style={styles.loginTitle}>Login</h1>
        <form onSubmit={handleSubmit} style={styles.loginForm}>
          <div style={styles.formGroup}>
            <label htmlFor="email" style={styles.formLabel}>
              Email
            </label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              style={styles.formInput}
              required
            />
          </div>
          <div style={styles.formGroup}>
            <label htmlFor="password" style={styles.formLabel}>
              Password
            </label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              style={styles.formInput}
              required
            />
          </div>
          <button type="submit" style={styles.loginButton}>
            Login
          </button>
        </form>
      </div>
    </div>
  );
};

const App = () => {
  return (
    <div style={styles.appContainer}>
      <h1 style={styles.appTitle}>
        <img src="books.jpg" alt="Book Icon" style={styles.bookIcon} />
        Book Bazaar
      </h1>
      <Login />
    </div>
  );
};

export default App;
