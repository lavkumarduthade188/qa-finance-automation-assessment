# Manual Test Cases — OrangeHRM Authentication Workflows

---

### TC_001: [Positive] Successful login with valid admin credentials.
* **Priority:** High
* **Steps:**
  1. Navigate to the OrangeHRM login portal.
  2. Enter 'Admin' in the username field.
  3. Enter 'admin123' in the password field.
  4. Click the 'Login' button.
* **Expected Result:** User is successfully authenticated and redirected to the home dashboard page. The URL contains `/dashboard`.

---

### TC_002: [Positive] Password masking security display.
* **Priority:** Medium
* **Steps:**
  1. Navigate to the login portal.
  2. Type characters into the password input field.
* **Expected Result:** The characters typed into the password field are masked as dots/asterisks to prevent shoulder-surfing.

---

### TC_003: [Negative] Login failure due to incorrect password input.
* **Priority:** High
* **Steps:**
  1. Navigate to the login portal.
  2. Enter 'Admin' as the username.
  3. Enter 'Pass123' as the password.
  4. Click 'Login'.
* **Expected Result:** Access is blocked. A clear warning message banner displays: 'Invalid credentials'. User remains on the login page.

---

### TC_004: [Negative] Login validation check with empty required fields.
* **Priority:** High
* **Steps:**
  1. Navigate to the login portal.
  2. Leave username and password fields blank.
  3. Click the 'Login' button.
* **Expected Result:** The form submission is blocked. Inline error alerts reading 'Required' display under both missing input fields.

---

### TC_005: [Negative] Unauthorized direct page access bypass attempt.
* **Priority:** High
* **Steps:**
  1. Open a fresh browser window session.
  2. Attempt to bypass login by directly browsing to the dashboard index link `https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index`
* **Expected Result:** The system blocks unauthorized access, rejects the request, and forces a redirection back to the login authentication page.

---

### TC_006: [Boundary] Input field text length maximum limit check.
* **Priority:** Medium
* **Steps:**
  1. Navigate to the login portal.
  2. Paste a continuous string of 300+ characters into the username text box.
  3. Enter 'admin123' as the password.
  4. Click 'Login'.
* **Expected Result:** The text box handles the massive string boundary safely without crashing the system UI, and blocks submission showing 'Invalid credentials'.

---

### TC_007: [Boundary] Case-sensitivity verification on credential inputs.
* **Priority:** High
* **Steps:**
  1. Navigate to the login portal.
  2. Type 'admin' (all lowercase) in the username field.
  3. Type 'ADMIN123' (all uppercase) in the password field.
  4. Click 'Login'.
* **Expected Result:** Authentication fails due to strict system case-sensitivity matches. The system displays the standard 'Invalid credentials' warning.
