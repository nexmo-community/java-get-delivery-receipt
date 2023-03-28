# ⚠️ This repository is no longer maintained.

<img src="https://developer.nexmo.com/assets/images/Vonage_Nexmo.svg" height="48px" alt="Nexmo is now known as Vonage" />

## Support Notice
This is an archived repository. If you have any questions, feel free to reach out to us at devrel@vonage.com or through our Community Slack at https://developer.vonage.com/community/slack.

<hr />

## Get a Delivery Receipt From Nexmo SMS API

This is the source code for the Nexmo Developer Blog tutorial that can be found [here]().

### Prerequisites

* A [Nexmo account](https://dashboard.nexmo.com/sign-up) to rent a virtual number you can send SMS from.
* The JDK, version 8 or later.
* [Gradle](https://gradle.org/install/) (version 3.4 or later) to build the project and manage its dependencies.
* [ngrok](https://ngrok.com) to make your webhook available over the public Internet.

### Purchase a Nexmo Number

You need a Nexmo number to send SMS messages from. Either purchase one directly in the [developer dashboard](https://dashboard.nexmo.com), or use the [Nexmo CLI tool](https://github.com/Nexmo/nexmo-cli):

Install the Nexmo CLI:

```sh
npm install -g nexmo-cli
```

Configure it with your `NEXMO_API_KEY` and `NEXMO_API_SECRET`:

```sh
nexmo setup NEXMO_API_KEY NEXMO_API_SECRET
```

Find numbers with SMS capability that are available for purchase in your country, by replacing `GB` in the following command with your own [two-character country code](https://www.worldatlas.com/aatlas/ctycodes.htm):

```sh
nexmo number:search GB --sms --verbose
```

Select a number and buy it:

```sh
nexmo number:buy NEXMO_NUMBER
```

### Make Your Webhook Accessible

Download and install `ngrok`, then execute the following command to expose your application on port 3000 to the public Internet:

```sh
ngrok http 3000
```

Make a note of the public URLs that `ngrok` provides and leave it running for the duration of this tutorial (because it gives you a new random URL every time you run it):


### Configure Your Nexmo Account

Log into the [developer dashboard](https://dashboard.nexmo.com) and under your account name in the left-hand navigation menu, select "Settings".

On the right-hand side of that page, under "Default SMS Setting", enter the full URL for your webhook (`ngrok` URL plus `/webhooks/delivery-receipt`) and click "Save changes". 

### Try it Out

Run the Java application from within your application directory:

```sh
gradle run
```

Use the Nexmo CLI to send a test message to your personal mobile number:

```sh
nexmo sms -f NEXMOTEST YOUR_PERSONAL_NUMBER "This is a test message"
```

Once Nexmo receives a delivery receipt from the network, it forwards this to your application which then displays it:

```sh
GET request
network-code: 23420
price: 0.03330000
messageId: 1400022045C7C1E0
scts: 1907161527
to: NEXMOTEST
err-code: 0
msisdn: 447700900005
message-timestamp: 2019-07-16 14:27:43
status: delivered
```
