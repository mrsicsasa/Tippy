# Tippy

Tippy is an Android application developed using **Kotlin** and **XML**, inspired by lectures from Stanford's Android development course. The app is designed to calculate the split of a bill among a group of people while determining the appropriate tip amount. It also provides visual feedback through smiley icons based on the percentage of the tip.

## Features

- **Bill Splitting**: Easily divide the total bill among multiple people.
- **Tip Calculation**: Choose a tip percentage, and the app calculates the total amount including the tip.
- **Dynamic Feedback**: Displays different smiley icons based on the tip percentage, making the experience more interactive and fun.

## Technologies Used

- **Kotlin**: For application logic and functionality.
- **XML**: For designing the user interface.
- **Android SDK**: Core framework for building the app.

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/mrsicsasa/Tippy.git
   ```

2. Open the project in **Android Studio**.

3. Sync Gradle files to download the required dependencies.

4. Build and run the app on an emulator or physical Android device.

## How It Works

1. **Input Bill Amount**: Enter the total bill amount in the provided field.
2. **Set Tip Percentage**: Use the slider or input to choose a tip percentage.
3. **Group Split**: Specify the number of people sharing the bill.
4. **Get Results**: View the total amount per person and see a smiley icon reflecting the generosity of the tip:
   - **Poor (0-9%)**: 😞
   - **Acceptable (10-14%)**: 😐
   - **Good (15-19%)**: 😊
   - **Great (20-24%)**: 😄
   - **Amazing (25% and above)**: 😍

## Future Enhancements

- **Customization**: Allow users to set default tip percentages.
- **Theme Options**: Add light and dark mode support.
- **Localization**: Support multiple languages and currencies.
- **History Tracking**: Save previous calculations for future reference.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

Feel free to contribute to this project and suggest new features! 😊

